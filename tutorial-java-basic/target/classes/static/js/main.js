$.ajax({
    url: '/hello/world',
    type: 'get',
    async: false,
    contentType: 'application/json',
    dataType: 'json',
    success: function (response) {
        console.log(response);
    }
})