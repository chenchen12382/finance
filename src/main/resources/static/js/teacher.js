$('#add_btn').click(function () {
    var data = {"offClassNumStart":$("#offClassNumStart").val(),'offClassNumOver':$('#offClassNumOver').val(),
        'classMoney':$('#classMoney').val()}
    modal(null,data);
});


function modal(id,data) {
    var url = ctx+'teacher/add';
    if(id!=null){
        url=ctx+'teacher/update';
    }
    var data = data;
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



function edit(id,row) {
    // var test=$('#teacher_qz tbody tr').eq(row).find("td")[2].html();
    // for(var i=0; i<=test; i++)
    // {
    //     numberStr = $("#already_question_list tr").eq(i).find("td:first").html();
    //     filter_numbs.push(numberStr);
    // }

    alert(test)
 var id = id;
    var data = {"offClassNumStart":$("#offClassNumStart").val(),'offClassNumOver':$('#offClassNumOver').val(),
        'classMoney':$('#classMoney').val(),id:id}
 modal(id,data);
}

function  resetValue() {
    $("#offClassNumStart").val("");
    $("#offClassNumOver").val("");
    $("#offClassNumOver").val("");
}
