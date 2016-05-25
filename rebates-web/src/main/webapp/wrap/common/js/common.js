//通过id设置值
function setValueById(id,value){
    if(id != null && id != ""){
        if(value != null && value != ""){
            $("#"+id).val(value);
        }else{
            return "error: value is null";
        }
    }else{
        return "error: id is null";
    }
}
//通过id获取值
function getValueById(id){
    if(id != null && id != ""){
        return $("#"+id).val();
    }else{
        return "error: id is null";
    }
}
//消息提示
function messageBox(messageTitle,messageText){
    $.gritter.add({
        title: messageTitle,
        text: messageText,
        class_name: 'gritter-info gritter-center'
    });
}