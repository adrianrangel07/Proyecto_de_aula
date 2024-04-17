function openOfferDetails(offerId) {
    var offerDetails = getOfferDetails(offerId);
    document.getElementById("offerDetailsTitle").innerText = offerDetails.title;
    document.getElementById("offerDetailsDescription").innerText = offerDetails.description;
    document.getElementById("offerDetails").style.display = "block";
}

function getOfferDetails(offerId) {
    var offerElement = document.querySelector('.offer[data-id="' + offerId + '"]');
    if (!offerElement) {
        return {
            title: 'Offer Not Found',
            description: 'Details not available'
        };
    }

    var title = offerElement.querySelector('.datos h3').innerText;
    var description = offerElement.querySelector('.datos p').innerText;

    return {
        title: title,
        description: description
    };
}

function closeOfferDetails() {
    document.getElementById("offerDetails").style.display = "none";
}
