jQuery(document).ready(function () {
    jQuery(".content").hide();
    jQuery(".badge").click(function () {
        jQuery(this).next(".content").slideToggle(500);
    });
});