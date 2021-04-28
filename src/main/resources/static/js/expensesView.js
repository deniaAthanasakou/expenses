$(document).ready(function(){
    var date_input_from=$('input[name="fromDate"]'); //our date input has the name "fromDate"
    var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
    var options={
        format: 'yyyy/mm/dd',
        container: container,
        todayHighlight: true,
        autoclose: true,
    };
    date_input_from.datepicker(options);


    var date_input_to=$('input[name="toDate"]'); //our date input has the name "toDate"
    date_input_to.datepicker(options);
})

function toggle(source) {
    var checkboxes = document.querySelectorAll('input[type="checkbox"]');
    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i] != source)
            checkboxes[i].checked = source.checked;
    }
}