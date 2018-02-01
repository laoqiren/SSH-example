$('#add_train').on('click',function(event){
        $('#trains_tbl tbody').append(`
        <tr>
            <td><input type="text"/></td>
            <td><input type="text"/></td>
            <td><input type="text"/></td>
            <td><input type="text"/></td>
            <td><input type="text"/></td>
            <td>
                <button type="button" class="add btn btn-sm btn-primary">提交添加</button>
            </td>
        </tr>`);

        $('.add').on('click',function(event){
            let $item = $(this).parent().parent();
            let number = $item.find('input').first().val(),
            	startId = $item.find('input').eq(1).val(),
            	endId = $item.find('input').eq(2).val(),
            	center = $item.find('input').eq(3).val(),
            	time = $item.find('input').eq(4).val();

            let myHeaders = new Headers({
                "Content-Type": "application/x-www-form-urlencoded"
             });
            let myInit = { 
                    method: 'POST',
                    headers: myHeaders,
                    credentials: "same-origin",
                    body: `number=${number}&startId=${startId}&endId=${endId}&center=${center}&time=${time}`
            };
            fetch("/trainBooking/addTrain",myInit)
                .then(function(response){
                    if(response.ok){
                        location.reload();
                    }
                })
            handleDelete();
        });
});

handleDelete();
function handleDelete(){
    $('.delete').on('click',function(event){
        let trainId = $(this).attr('id');
        let $item = $(this).parent().parent();

        let myHeaders = new Headers({
            "Content-Type": "application/x-www-form-urlencoded"
         });
        let myInit = { 
            method: 'POST',
            headers: myHeaders,
            credentials: "same-origin",
            body: `number=${trainId}`
        };
        fetch("/trainBooking/deleteTrain",myInit)
            .then(function(response){
                if(response.ok){
                	return response.text();
                }
            })
            .then(function(body){
            	if(body === 'success'){
            		$item.remove();
            	}
            });
    });
}