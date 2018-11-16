;
var display_datetime_id_element = "";

/**
 * <h4>显示 时钟</h4>
 * @param idElement 要显示控件的ID
 */
function displayClock(idElement) {
    display_datetime_id_element = idElement;
    setInterval("currentTime()",1000);
}

//时间设置
function currentTime(){
    var weekday=new Array(7);
    weekday[1]="星期一";
    weekday[2]="星期二";
    weekday[3]="星期三";
    weekday[4]="星期四";
    weekday[5]="星期五";
    weekday[6]="星期六";
    weekday[0]="星期日";
    var d = new Date(),str='';
    str += d.getFullYear()+'年';
    str += d.getMonth() + 1+'月';
    str += d.getDate()+'日';
    str += d.getHours()+'时';
    if (d.getMinutes() < 10) {
        str += "0";
    }
    str += d.getMinutes()+'分';
    if (d.getSeconds() < 10) {
        str += "0";
    }
    str += d.getSeconds();
    str += '秒'+'&nbsp;&nbsp;';
    str += weekday[d.getDay()];
    $(display_datetime_id_element).html(str)
}