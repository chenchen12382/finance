$('#add_btn').click(function () {
    modal(null);
});


function modal(id) {
    var url = ctx+'teacher/add';
    if(id!=null){
        url=ctx+'teacher/update';
    }
    var data = {"offClassNumStart":$("#offClassNumStart").val(),'offClassNumOver':$('#offClassNumOver').val(),
        'classMoney':$('#classMoney').val(),id:id}
    $('#my-prompt').modal({
        relatedTarget: this,
        onConfirm: function(e) {

            $.post(url,data,function(data){
                if(data.resultCode==1){
                    alert("操作成功");
                    resetValue();
                    location.reload();
                }else {
                    alert(data.resultMessage);
                    resetValue();
                }
            });

        }
    });

}



function edit(id) {
 var id = id;
 var url = ctx+'teacher/selectForId'
 var param={'id':id};
    var offClassNumStart;
    var offClassNumOver;
    var classMoney;

    $.post(url,param,function (result) {

    offClassNumStart = result.offClassNumStart;
    offClassNumOver = result.offClassNumOver;
    classMoney = result.classMoney;
 });
    $('#offClassNumStart').val(offClassNumStart);
    $('#offClassNumOver').val(offClassNumOver);
    $('#classMoney').val(classMoney);

 modal(id);
}

function  resetValue() {
    $("#offClassNumStart").val("");
    $("#offClassNumOver").val("");
    $("#offClassNumOver").val("");
}
