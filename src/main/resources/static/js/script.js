/**
 * 
 */
 function aggiungiOmbra() {
    document.addEventListener('DOMContentLoaded', function() {
        // Seleziona tutte le card all'interno del div specifico
        var cards = document.querySelectorAll('[id^="card"]');
        
        cards.forEach(function(card) {
            // Aggiungi un listener per l'evento mouseover a ciascuna card
            card.addEventListener('mouseover', function() {
                // Applica l'ombra quando il mouse passa sopra alla card
                card.style.boxShadow = 'inset 0 0 50px 40px rgb(40, 40, 40)';
            });
            
            // Aggiungi un listener per l'evento mouseout a ciascuna card
            card.addEventListener('mouseout', function() {
                // Rimuovi l'ombra quando il mouse esce dalla card
                card.style.boxShadow = 'none';
            });
        });
    });
}
// Chiama la funzione per aggiungere l'ombra alle card
aggiungiOmbra();


/*CONTROLLO DIMENSIONE FILE IMMAGINE*/ 
document.getElementById('fileInput').addEventListener('change', function() {
    const file = this.files[0];
    if (file.size > 1048576) { // 1 megabyte in bytes
      alert('La dimensione massima consentita per l\'immagine è di 1 MB.');
      this.value = ''; // Resetta il valore dell'input file
    }
  });