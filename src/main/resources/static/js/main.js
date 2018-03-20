
$(document).ready(function(){
    $('.nBtn, .table .eBtn').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();

        if (text == 'Edit') {
            $.get(href, function (users, status) {
                $('.myFormUpdate #id').val(users.id);
                $('.myFormUpdate #username').val(users.username);
                $('.myFormUpdate #password').val(users.password);
                $('.myFormUpdate #email').val(users.email);
            });
            $('.myFormUpdate #updateModal').modal();
        } else {
            // $('.myFormCreate #id').val('');
            $('.myFormCreate #username').val('');
            $('.myFormCreate #password').val('');
            $('.myFormCreate #email').val('');
            $('.myFormCreate #myModalCreate').modal();
        }
    });
    $('.table .delBtn').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#removeModalCenter #delRef').attr('href', href);
        $('#removeModalCenter').modal();
    });
});



