(function () {

    function copyBillingAddress() {
        var billingInputElements = document.querySelectorAll("#billingAddress input");
        var shippingInputElements = document.querySelectorAll("#shippingAddress input");
        if (document.getElementById("defaultCheck1").checked) {
            for (var i = 0; i < billingInputElements.length; i++) {
                shippingInputElements[i].value = billingInputElements[i].value;
            }
            document.querySelector("#shippingAddress select").value = document.querySelector("#billingAddress select").value;
        } else {
            for (var i = 0; i < billingInputElements.length; i++) {
                shippingInputElements[i + 1].value = "";
            }
            document.querySelector("#shippingAddress select").selectedIndex = -1;
        }
    }

    document.getElementById("defaultCheck1").addEventListener('change',
        function () {
            copyBillingAddress();
        }
    );
})();

function validateFirstName() {
    let f = false;

    let name = $(".name-field").val();
    if (name == '' || name == undefined) {
        $(".name-field-msg")
            .html("First name can't be empty but max char less than 256")
            .addClass("text-danger");
        f = false;
    } else {
        $(".name-field-msg")
            .html("ok!!")
            .removeClass("text-danger")
            .addClass("text-success")
        f = true;
    }
    return f;
}
function validateLastName() {
    let f = false;
    let lastName = $(".last-name-field").val();
    if (lastName == '' || lastName == undefined) {
        $(".last-name-field-msg")
            .html("Last name can't be empty but max char less than 256")
            .addClass("text-danger");
        f = false;
    } else {
        $(".last-name-field-msg")
            .html("ok!!")
            .removeClass("text-danger")
            .addClass("text-success")
        f = true;
    }
    return f;
}
function validateEmail() {
    let f = false;
    let email = $(".email-field").val();
    let exp =/\S+@\S+\.\S+/;
    if (email == '' || email == undefined) {
        $(".email-field-msg")
            .html("Email is required!!")
            .addClass("text-danger");
        f = false;
    } else if (exp.test(email) == false) {
        $(".email-field-msg")
            .html("Invalid Email!! must be like email@example.com")
            .addClass("text-danger");
        f = false;
    } else {
        $(".email-field-msg")
            .html("Ok!!")
            .removeClass("text-danger")
            .addClass("text-success");
        f = true;
    }
    return f;
}
function validateBillAddressLine1() {
    let f= false;
    let address11 = $(".addressLine-field-11").val();
    if (address11 == '' || address11 == undefined) {
        $(".addressLine-field-msg-11")
            .html("address can't be empty but max char less than 256")
            .addClass("text-danger");
        f = false;
    } else {
        $(".addressLine-field-msg-11")
            .html("ok!!")
            .removeClass("text-danger")
            .addClass("text-success")
        f = true;
    }
    return f;
}
function validateBillAddressLine2() {
    let f= false;
    let address12 = $(".addressLine-field-12").val();
    if (address12 == '' || address12 == undefined) {
        $(".addressLine-field-msg-12")
            .html("address can't be empty but max char less than 256")
            .addClass("text-danger");
        f = false;
    } else {
        $(".addressLine-field-msg-12")
            .html("ok!!")
            .removeClass("text-danger")
            .addClass("text-success")
        f = true;
    }
    return f;
}
function validateShipAddressLine1() {
    let f= false;
    let address21 = $(".addressLine-field-21").val();
    if (address21 == '' || address21 == undefined) {
        $(".addressLine-field-msg-21")
            .html("address can't be empty but max char less than 256")
            .addClass("text-danger");
        f = false;
    } else {
        $(".addressLine-field-msg-21")
            .html("ok!!")
            .removeClass("text-danger")
            .addClass("text-success")
        f = true;
    }
    return f;
}
function validateShipAddressLine2() {
    let f= false;
    let address22 = $(".addressLine-field-22").val();
    if (address22 == '' || address22 == undefined) {
        $(".addressLine-field-msg-22")
            .html("address can't be empty but max char less than 256")
            .addClass("text-danger");
        f = false;
    } else {
        $(".addressLine-field-msg-22")
            .html("ok!!")
            .removeClass("text-danger")
            .addClass("text-success")
        f = true;
    }
    return f;
}

function validateCity1() {
    let f= false;
    let city1 = $(".city-field-1").val();
    if (city1 == '' || city1 == undefined) {
        $(".city-field-msg-1")
            .html("Required field with max 256 char")
            .addClass("text-danger");
        f = false;
    } else {
        $(".city-field-msg-1")
            .html("ok!!")
            .removeClass("text-danger")
            .addClass("text-success")
        f = true;
    }
    return f;
}
function validateCity2() {
    let f=false;
    let city2 = $(".city-field-2").val();
    if (city2 == '' || city2 == undefined) {
        $(".city-field-msg-2")
            .html("Required field with max 256 char")
            .addClass("text-danger");
        f = false;
    } else {
        $(".city-field-msg-2")
            .html("ok!!")
            .removeClass("text-danger")
            .addClass("text-success")
        f = true;
    }
    return f;
}
function validateState1() {
    let f=false;
    let state1 = $(".state-field-1").val();
    if (state1 == '' || state1 == undefined) {
        $(".state-field-msg-1")
            .html("Required field with max 256 char")
            .addClass("text-danger");
        f = false;
    } else {
        $(".state-field-msg-1")
            .html("ok!!")
            .removeClass("text-danger")
            .addClass("text-success")
        f = true;
    }
    return f;
}
function validateState2() {
    let f= false;
    let state2 = $(".state-field-2").val();
    if (state2 == '' || state2 == undefined) {
        $(".state-field-msg-2")
            .html("Required field with max 256 char")
            .addClass("text-danger");
        f = false;
    } else {
        $(".state-field-msg-2")
            .html("ok!!")
            .removeClass("text-danger")
            .addClass("text-success")
        f = true;
    }
    return f;
}
function validateCountry1() {
    let f= false;
    let country1 = $(".country-field-1").val();
    if (country1 == '' || country1 == undefined) {
        $(".country-field-msg-1")
            .html("Required field with max 256 char")
            .addClass("text-danger");
        f = false;
    } else {
        $(".country-field-msg-1")
            .html("ok!!")
            .removeClass("text-danger")
            .addClass("text-success")
        f = true;
    }
    return f;
}
function validateCountry2() {
    let f= false;
    let country2 = $(".country-field-2").val();
    if (country2 == '' || country2 == undefined) {
        $(".country-field-msg-2")
            .html("Required field with max 256 char")
            .addClass("text-danger");
        f = false;
    } else {
        $(".country-field-msg-2")
            .html("ok!!")
            .removeClass("text-danger")
            .addClass("text-success")
        f = true;
    }
    return f;
}

function validateZipCode1() {
    let f= false;
    let zipcode1 = $(".zipcode-field-1").val();
    if (zipcode1 == '' || zipcode1 == undefined) {
        $(".zipcode-field-msg-1")
            .html("Required field with max 256 char")
            .addClass("text-danger");
        f = false;
    } else {
        $(".zipcode-field-msg-1")
            .html("ok!!")
            .removeClass("text-danger")
            .addClass("text-success")
        f = true;
    }
    return f;
}
function validateZipCode2() {
    let f=false;
    let zipcode2 = $(".zipcode-field-2").val();
    if (zipcode2 == '' || zipcode2 == undefined) {
        $(".zipcode-field-msg-2")
            .html("Required field with max 256 char")
            .addClass("text-danger");
        f = false;
    } else {
        $(".zipcode-field-msg-2")
            .html("ok!!")
            .removeClass("text-danger")
            .addClass("text-success")
        f = true;
    }
    return f;
}
function validatePhone() {
    let f = false;
    let phone = $(".phone-field").val();
    let phoneExp = /^(?:(?:\+|0{0,2})91(\s*[\-]\s*)?|[0]?)?[789]\d{9}$/;
    if (phone == '' || phone == undefined) {
        $(".phone-field-msg")
            .html("Phone Number required!!")
            .addClass("text-danger");
        f = false;
    } else if (phoneExp.test(phone) == false) {
        $(".phone-field-msg")
            .html("Must be an Indian mobile number")
            .addClass("text-danger");
        f = false;
    }
    else {
        $(".phone-field-msg")
            .html("ok!!")
            .removeClass("text-danger")
            .addClass("text-success")
        f = true;
    }

    return f;
}

function validate() {
    let f= false;
    if (validateFirstName()&&validateLastName()&&validateEmail()&&validatePhone()
        &&validateBillAddressLine1()&&validateBillAddressLine2()
        &&validateShipAddressLine1()&&validateShipAddressLine2()
       &&validateCity1()&&validateCity2()
       &&validateState1()&&validateState2()
       &&validateCountry1()&&validateCountry2()
       &&validateZipCode1()&&validateZipCode2()) {
        f= true;
    } else {
        f=false;
    }

    return f;
}