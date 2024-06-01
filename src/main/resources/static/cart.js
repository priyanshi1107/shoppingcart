var tbody = document.getElementById("tbody");
var subtotal = document.getElementById("subtotal");
var totaltax = document.getElementById("totaltax");
var grandtotal = document.getElementById("grandtotal");
var quantity = 1;

function addRow(cartedProduct) {
    var counts = (tbody.rows.length) ;
    tbody.appendChild(document.createElement("tr")).innerHTML = `
        <td scope="col" style="width:10%" class="serial"></td>
        <td scope="col" style="width:20%" ><input name=${'productList['+counts+'].productName'} value='${cartedProduct['name']}' class="border-none" style="width:100px;text-align:center" readonly/></td>
        <td scope="col" style="width:20%" ><img src='${cartedProduct["image"]}' style="width:100px"></td>
        <input name=${'productList['+counts+'].imageUrl'} value='${cartedProduct['image']}' hidden/>
        <td scope="col" style="width:15%" ><input class="price border-none" name=${'productList['+counts+'].price'} value='${cartedProduct['price']}' style="width:100px;text-align:center"readonly/></td>
        <td scope="col" style="width:10%" ><input class="quantity" type="number"  name=${'productList['+counts+'].qty'} value="1" style="width:50px;text-align:center" min="1" max='${cartedProduct["maxQty"]}' required="required"></td>
        <td scope="col" style="width:15%" ><input class="total border-none" name=${'productList['+counts+'].total'} style="width:100px;text-align:center" readonly></input></td>
        <td scope="col" style="width:10%"><a class="fa fa-trash" style="font-size:24px;color:grey" onClick="deleteRow(this, ${cartedProduct["id"]})"></a></td>`
};
function nextAlert(){
    let f= false;
    if (grandtotal.value==''|| grandtotal.value==undefined||grandtotal.value==0||grandtotal.value==NaN){
        f= false;
        alert("Please update the cart to fill User Details!!");
    }else{
        sessionStorage.clear();
        f = true;
    }
    console.log(f);
    return f;
}
function serialize() {
    const list = document.querySelectorAll(".serial");
    list.forEach((ele, idx) => {
        ele.innerHTML = idx + 1;
    })
}

function deleteRow(e, id) {
    sessionStorage.removeItem("cartedProduct"+id);
    e.parentNode.parentNode.parentNode.removeChild(e.parentNode.parentNode);
    serialize();
}

(function iterate() {
    var arrayOfValues = [];
    for (var i in sessionStorage) {
        if (sessionStorage.hasOwnProperty(i)) {
            arrayOfValues.push(JSON.parse(sessionStorage[i]));
        }
    }
    arrayOfValues.forEach(j => addRow(j));
    serialize();
})();

function evaluation(){
    var price = document.querySelectorAll(".price");
    var quantity = document.querySelectorAll(".quantity");
    var total = document.querySelectorAll(".total");
    var tot = [];
    for(var i=0;i<price.length;i++){
        total[i].value = parseInt(price[i].value)*parseInt(quantity[i].value);
        tot[i] = total[i].value;
    }
    subtotal.value = tot.reduce((a,c)=>{return parseInt(a)+parseInt(c)},0);
    totaltax.value = subtotal.value*0.1;
    grandtotal.value = parseInt(subtotal.value)+parseInt(totaltax.value);

}

