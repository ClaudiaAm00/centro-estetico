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
                card.style.boxShadow = 'inset 0 0 50px 40px rgb(40, 40, 40, 0.5)';
                //card.style.filter = 'brightness(70%)';
            });
            
            // Aggiungi un listener per l'evento mouseout a ciascuna card
            card.addEventListener('mouseout', function() {
                // Rimuovi l'ombra quando il mouse esce dalla card
                card.style.boxShadow = 'none';
                //card.style.filter = 'brightness(100%)';
            });
        });
    });
}

aggiungiOmbra();

/*function aggiungiOmbra() {
    document.addEventListener('DOMContentLoaded', function() {
        let cards = document.querySelectorAll('.card-with-overlay');
        let staff = document.getElementsByClassName(infoStaff);
        let img = document.getElementsByClassName(imgStaff);
        
        cards.forEach(function(card) {
            let overlay = document.createElement('div'); // Creare l'elemento overlay
            overlay.classList.add('overlay'); // Aggiungere la classe overlay
            card.appendChild(overlay); // Aggiungere overlay come figlio della card
            
            card.addEventListener('mouseover', function() {
				staff.style.zIndex = '5';
				img.style.zIndex = '0';
                overlay.style.opacity = '0.5'; // Opacità dimezzata
                
               
                
            });
            
            card.addEventListener('mouseout', function() {
                overlay.style.opacity = '0'; // Opacità nulla
            });
        });
    });
}

// Chiama la funzione per aggiungere l'overlay alle card
aggiungiOmbra();
*/


/*CONTROLLO DIMENSIONE FILE IMMAGINE*/ 
document.getElementById('fileInput').addEventListener('change', function() {
    const file = this.files[0];
    if (file.size > 1048576) { // 1 megabyte in bytes
      alert('La dimensione massima consentita per l\'immagine è di 1 MB.');
      this.value = ''; // Resetta il valore dell'input file
    }
  });