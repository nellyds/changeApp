$(document).ready(function () {

    $("#submitAmount").submit(function (event) {
        console.log("yo")
        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {

    var value = $("#dollarValue").val();
    console.log("hi");
    $("#btn-sbmt").prop("disabled", true);

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/api?dollarValue="+ value,
        data: JSON.stringify(value),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Sure, why not?</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-sbmt").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>OH DEAR GOD NO! </h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-sbmt").prop("disabled", false);

        }
    });

}