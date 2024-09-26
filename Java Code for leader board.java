


// Replace with your Google Sheets ID and API key
const sheetId = 'family-leader-board';
const apiKey = 'AIzaSyDsRZsQbQyu_WJomed9GG51fQuV0awUFnI';

async function fetchLeaderboard() {
    // Fetch data from Google Sheets
    const response = await fetch(`https://sheets.googleapis.com/v4/spreadsheets/${sheetId}/values/Sheet1?key=${apiKey}`);
    const data = await response.json();
    const rows = data.values;
    
    // Display the data in the leaderboard
    const leaderboard = document.getElementById('leaderboard');
    leaderboard.innerHTML = ''; // Clear the leaderboard
    
    rows.forEach((row, index) => {
        const rank = index + 1;
        const name = row[0];
        const score = row[1];
        leaderboard.innerHTML += `<tr><td>${rank}</td><td>${name}</td><td>${score}</td></tr>`;
    });
}

// Fetch and display the leaderboard when the page loads
window.onload = fetchLeaderboard;
