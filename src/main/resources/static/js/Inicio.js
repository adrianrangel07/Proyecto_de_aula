document.addEventListener('DOMContentLoaded', function() {
    const offers = document.querySelectorAll('.offer');
    const offerDetails = document.querySelector('.offerDetails');

    offers.forEach(offer => {
        offer.addEventListener('click', function() {
            const tituloPuesto = this.querySelector('h3').innerText;
            const descripcion = this.querySelector('p').innerText;           
            offerDetails.querySelector('h3').innerText = tituloPuesto;
            offerDetails.querySelector('p').innerText = descripcion;           
            offerDetails.style.display = 'block';
        });
    });

    const closeOfferDetails = document.getElementById('closeOfferDetails');
    if (closeOfferDetails) {
        closeOfferDetails.addEventListener('click', function() {
            offerDetails.style.display = 'none';
        });
    }
});

