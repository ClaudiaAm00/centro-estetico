/**
 * 
 */
 function aggiungiOmbra(){

    var card = document.getElementById("card"); 

    card.addEventListener('mouseover', function(){
        card.style.boxShadow = 'inset 0 0 50px 40px rgb(40, 40, 40)';
    });
    

    card.addEventListener('mouseout', function(){
        card.style.boxShadow = 'none';
    });
}

aggiungiOmbra();

/*CONTROLLO DIMENSIONE FILE IMMAGINE*/ 
document.getElementById('fileInput').addEventListener('change', function() {
    const file = this.files[0];
    if (file.size > 1048576) { // 1 megabyte in bytes
      alert('La dimensione massima consentita per l\'immagine è di 1 MB.');
      this.value = ''; // Resetta il valore dell'input file
    }
  });