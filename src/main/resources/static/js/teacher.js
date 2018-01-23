$('#add_btn').click(function () {
        $('#my-confirm').modal({
            relatedTarget: this,
            onConfirm: function(options) {
                var $link = $(this.relatedTarget).prev('a');
                var msg = $link.length ? '你要删除的链接 ID 为 ' + $link.data('id') :
                    '确定了，但不知道要整哪样';
                alert(msg);
            },
            // closeOnConfirm: false,
            onCancel: function() {
                alert('算求，不弄了');
            }
        });
})

