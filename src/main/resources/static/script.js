var productInfo = {};
var clickedId;

(function infoLoader() {
    var cards = document.querySelectorAll(".card");
    console.log(cards.length);
    for (var i = 0; i < cards.length; i++) {
        productInfo[cards[i].id] = {
            id: cards[i].id,
            name: cards[i].querySelector(".card-title").innerText,
            price: cards[i].querySelector(".card-text").innerText,
            image: cards[i].querySelector(".card-img-top").src,
            maxQty: cards[i].querySelector(".card-max").innerText
        }
    }
    console.log(productInfo);
})();

(function getProductInfo() {
    var addToCart = document.querySelectorAll(".btn");
    for (var i = 0; i < addToCart.length; i++) {
        addToCart[i].addEventListener("click", (e) => {
            clickedId = e.target.parentNode.parentNode.id;
            window.sessionStorage.setItem("cartedProduct"+clickedId, JSON.stringify(productInfo[clickedId]));
        })
    }
})();
