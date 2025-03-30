// Main script for VitalGuard health monitoring application

// Function to calculate the health index based on user inputs
function calculateHealthIndex() {
    // Get user input values
    const age = parseInt(document.getElementById('age').value);
    const pulseRate = document.getElementById('pulse').value;
    const bloodPressure = document.getElementById('bp').value;
    
    // Validate inputs
    if (!age || age < 1 || age > 120) {
        alert("Please enter a valid age between 1 and 120.");
        return;
    }
    
    if (!pulseRate || isNaN(pulseRate)) {
        alert("Please enter a valid pulse rate.");
        return;
    }
    
    // Validate blood pressure format (systolic/diastolic)
    const bpPattern = /^\d+\/\d+$/;
    if (!bloodPressure || !bpPattern.test(bloodPressure)) {
        alert("Please enter blood pressure in the format systolic/diastolic (e.g., 120/80).");
        return;
    }
    
    // Parse blood pressure values
    const [systolic, diastolic] = bloodPressure.split('/').map(num => parseInt(num));
    
    // Calculate health index
    let healthIndex = calculateHealthScore(age, parseInt(pulseRate), systolic, diastolic);
    
    // Store results in localStorage to access them on the results page
    localStorage.setItem('healthIndex', healthIndex.toFixed(2));
    localStorage.setItem('age', age);
    localStorage.setItem('pulseRate', pulseRate);
    localStorage.setItem('bloodPressure', bloodPressure);
    
    // Redirect to the results page
    window.location.href = 'result.html';
}

// Function to calculate health score based on various factors
function calculateHealthScore(age, pulseRate, systolic, diastolic) {
    // Base score starts at 100
    let score = 100;
    
    // Adjust score based on pulse rate
    if (age < 18) {
        // Children and teenagers (normal range approximately 70-100 bpm)
        if (pulseRate < 60) score -= 10;
        else if (pulseRate > 100) score -= (pulseRate - 100) * 0.2;
    } else if (age >= 18 && age < 60) {
        // Adults (normal range approximately 60-80 bpm)
        if (pulseRate < 50) score -= 15;
        else if (pulseRate < 60) score -= 5;
        else if (pulseRate > 90) score -= (pulseRate - 90) * 0.3;
    } else {
        // Older adults (normal range approximately 60-80 bpm but more tolerance)
        if (pulseRate < 50) score -= 20;
        else if (pulseRate < 60) score -= 10;
        else if (pulseRate > 90) score -= (pulseRate - 90) * 0.25;
    }
    
    // Adjust score based on blood pressure
    // Normal BP: ~120/80 mmHg
    // Calculate deviation from ideal blood pressure
    const systolicDeviation = Math.abs(systolic - 120);
    const diastolicDeviation = Math.abs(diastolic - 80);
    
    // Apply penalties for blood pressure deviations
    if (systolic < 90 || systolic > 140 || diastolic < 60 || diastolic > 90) {
        // More significant penalties for concerning ranges
        score -= (systolicDeviation * 0.3 + diastolicDeviation * 0.3);
    } else {
        // Minor penalties for slight deviations
        score -= (systolicDeviation * 0.1 + diastolicDeviation * 0.1);
    }
    
    // Adjust score based on age
    // No penalty for ages 18-40
    if (age > 40) {
        score -= (age - 40) * 0.1; // Small reduction as age increases beyond 40
    }
    
    // Ensure score doesn't go below 0 or above 100
    return Math.max(0, Math.min(100, score));
}

// Function to load results on the result page
function loadResults() {
    // Check if we're on the results page
    const healthboxElement = document.getElementById('healthbox');
    if (!healthboxElement) return;
    
    // Get stored values from localStorage
    const healthIndex = localStorage.getItem('healthIndex');
    const age = localStorage.getItem('age');
    const pulseRate = localStorage.getItem('pulseRate');
    const bloodPressure = localStorage.getItem('bloodPressure');
    
    // Display health index
    healthboxElement.value = healthIndex;
    
    // Update description based on health index
    const descriptionElement = document.querySelector('.description');
    if (descriptionElement) {
        if (healthIndex >= 90) {
            descriptionElement.textContent = "Excellent! Your health indicators are in optimal range.";
        } else if (healthIndex >= 75) {
            descriptionElement.textContent = "Good. Your health indicators are within normal ranges.";
        } else if (healthIndex >= 60) {
            descriptionElement.textContent = "Fair. Consider lifestyle improvements to enhance your health metrics.";
        } else {
            descriptionElement.textContent = "Attention needed. Please consult with a healthcare professional.";
        }
    }
    
    // Add feedback based on individual parameters
    const feedbackElement = document.getElementById('feedback');
    if (feedbackElement) {
        let feedback = "";
        
        // Parse blood pressure
        const [systolic, diastolic] = bloodPressure.split('/').map(num => parseInt(num));
        
        // Add age-based advice
        if (age < 18) {
            feedback += "For your age group, regular physical activity and balanced nutrition are essential for healthy development.\n\n";
        } else if (age >= 65) {
            feedback += "For seniors, regular check-ups, staying active, and monitoring blood pressure are particularly important.\n\n";
        }
        
        // Add pulse rate advice
        if (pulseRate < 60) {
            feedback += "Your pulse rate is low. This could be normal for athletes, but consider consulting a doctor if you experience dizziness or fatigue.\n\n";
        } else if (pulseRate > 90) {
            feedback += "Your pulse rate is elevated. Try relaxation techniques and consider reducing caffeine intake.\n\n";
        }
        
        // Add blood pressure advice
        if (systolic > 130 || diastolic > 85) {
            feedback += "Your blood pressure is higher than optimal. Consider reducing sodium intake, maintaining a healthy weight, and regular exercise.\n\n";
        } else if (systolic < 100 || diastolic < 65) {
            feedback += "Your blood pressure is on the lower side. Stay hydrated and rise slowly from sitting or lying positions.\n\n";
        }
        
        // General health advice
        feedback += "General recommendations:\n- Stay hydrated (8 glasses of water daily)\n- Get 7-9 hours of quality sleep\n- Exercise for at least 30 minutes daily\n- Maintain a balanced diet rich in fruits and vegetables";
        
        feedbackElement.value = feedback;
    }
}

// Add event listener to load results when page loads
window.addEventListener('DOMContentLoaded', loadResults);