document.addEventListener('DOMContentLoaded', function() {
    const offerContainers = document.querySelectorAll('.offer');
    const footer = document.querySelector('.footer');

    function checkOfferPresence() {
        if (offerContainers.length === 0) {
            footer.style.position = 'fixed';
        } else {
            footer.style.position = 'relative';
        }
    }

    checkOfferPresence();

    window.addEventListener('resize', checkOfferPresence);
});



document.addEventListener('DOMContentLoaded', function () {
    const offers = document.querySelectorAll('.offer');
    const offerDetails = document.querySelector('.offerDetails');

    offers.forEach(offer => {
        offer.addEventListener('click', function () {
            const tituloPuesto = this.querySelector('h3').innerText;
            const descripcion = this.querySelector('p').innerText;
            offerDetails.querySelector('h3').innerText = tituloPuesto;
            offerDetails.querySelector('p').innerText = descripcion;
            offerDetails.style.display = 'block';
        });
    });

    const closeOfferDetails = document.getElementById('closeOfferDetails');
    if (closeOfferDetails) {
        closeOfferDetails.addEventListener('click', function () {
            offerDetails.style.display = 'none';
        });
    }
});

//filtro de busqueda
document.getElementById('formBusqueda').addEventListener('submit', function (event) {
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
            data.forEach(function (oferta) {
                var div = document.createElement('div');
                div.classList.add('offer');
                div.innerHTML = '<h3>' + oferta.titulo_puesto + '</h3><p>' + oferta.descripcion + '</p>';
                resultadoBusqueda.appendChild(div);
            });
        });
}

//oferta de detalles
document.addEventListener('DOMContentLoaded', function () {
    const offerDetails = document.querySelector('.offerDetails');

    const resultadoBusqueda = document.getElementById('resultadoBusqueda');

    resultadoBusqueda.addEventListener('click', function (event) {
        const clickedOffer = event.target.closest('.offer');
        if (clickedOffer) { // Check if clicked element or its ancestor is an offer
            const tituloPuesto = clickedOffer.querySelector('h3').innerText;
            const descripcion = clickedOffer.querySelector('p').innerText;

            const salarioElement = clickedOffer.querySelector('.salario span');
            const duracionElement = clickedOffer.querySelector('.duracion span');
            const periodoElement = clickedOffer.querySelector('.periodo span');
            const tipoEmpleoElement = clickedOffer.querySelector('.tipo_empleo span');

            const salario = salarioElement ? salarioElement.innerText : 'No hay información disponible';
            const duracion = duracionElement ? duracionElement.innerText : 'No hay información disponible';
            const periodo = periodoElement ? periodoElement.innerText : 'No hay información disponible';
            const tipoEmpleo = tipoEmpleoElement ? tipoEmpleoElement.innerText : 'No hay información disponible';

            offerDetails.style.display = 'block';
            offerDetails.querySelector('h3').innerText = tituloPuesto;
            offerDetails.querySelector('p').innerText = descripcion;
            offerDetails.querySelector('.salarioSpan').innerText = salario;
            offerDetails.querySelector('.duracionSpan').innerText = duracion;
            offerDetails.querySelector('.periodoSpan').innerText = periodo;
            offerDetails.querySelector('.tipo_empleoSpan').innerText = tipoEmpleo;
        }
    });
});