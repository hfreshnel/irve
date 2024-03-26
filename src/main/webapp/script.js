// Initialiser la carte
    var mymap = L.map('map').setView([51.505, -0.09], 13);

    // Ajouter la couche OpenStreetMap à la carte
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(mymap);

    // Ajouter un marqueur à un emplacement spécifique
    L.marker([51.5, -0.09]).addTo(mymap)
      .bindPopup('Un exemple de marqueur sur la carte.');
      
    // Appeler la fonction pour ajuster la hauteur de la carte au chargement de la page et lors du redimensionnement de la fenÃªtre
	setMapHeight();
	window.addEventListener('resize', setMapHeight);
      
     // Vérifier si le navigateur prend en charge la géolocalisation
 if (navigator.geolocation) {
     // Demander la position gÃ©ographique actuelle
     navigator.geolocation.getCurrentPosition(updateMapLocation, handleLocationError);
 } else {
     // Le navigateur ne prend pas en charge la géolocalisation
     console.error("La géolocalisation n'est pas prise en charge par ce navigateur.");
 }
      
function setMapHeight() {
    let windowHeight = window.innerHeight; // RÃ©cupÃ¨re la hauteur de la fenÃ¨tre en pixel
    let mapElement = document.getElementById('map'); //RÃ©cupÃ¨re le composant Ã  partir de son id qui est map
    mapElement.style.height = windowHeight + 'px';
}

 // Fonction pour gérer les erreurs de géolocalisation
 function handleLocationError(error) {
     console.error("Erreur de géolocalisation : ", error.message);
 }
 
  function updateMapLocation(position) {
     var latitude = position.coords.latitude;
     var longitude = position.coords.longitude;

     // Mettre à jour la carte avec la nouvelle position
     mymap.setView([latitude, longitude], 13);

     // Ajouter un marqueur à la position
    L.marker([latitude, longitude]).addTo(mymap)
         .bindPopup("Vous etes ici").openPopup();
 }