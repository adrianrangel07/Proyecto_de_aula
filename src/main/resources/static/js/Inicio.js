
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
    
    //filtro de busqueda
    document.getElementById('formBusqueda').addEventListener('submit', function(event) {
        event.preventDefault();
        var termino = document.getElementById('termino').value;
        buscarOfertas(termino);
    });

    function buscarOfertas(termino) {
        fetch('/buscar_ofertas?termino=' + termino)
            .then(response => response.json())
            .then(data => {
                var resultadoBusqueda = document.getElementById('resultadoBusqueda');
                resultadoBusqueda.innerHTML = '';
                data.forEach(function(oferta) {
                    var div = document.createElement('div');
                    div.classList.add('offer');
                    div.innerHTML = '<h3>' + oferta.titulo_puesto + '</h3><p>' + oferta.descripcion + '</p>';
                    resultadoBusqueda.appendChild(div);
                });
            });
    }

    document.addEventListener('DOMContentLoaded', function() {
        const offerDetails = document.querySelector('.offerDetails');
        const resultadoBusqueda = document.getElementById('resultadoBusqueda');
      
        resultadoBusqueda.addEventListener('click', function(event) {
          if (event.target.classList.contains('offer')) { // Check if clicked element is an offer
            const tituloPuesto = event.target.querySelector('h3').innerText;
            const descripcion = event.target.querySelector('p').innerText;
            offerDetails.querySelector('h3').innerText = tituloPuesto;
            offerDetails.querySelector('p').innerText = descripcion;
            offerDetails.style.display = 'block';
          }
        });
    })


    