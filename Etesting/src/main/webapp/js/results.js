jQuery(document).ready(function () {
    jQuery(".content").hide();
    jQuery(".heading").click(function () {
        jQuery(this).next(".content").slideToggle(500);
    });
});