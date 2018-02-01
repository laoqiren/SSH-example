$('#add_station').on('click',function(event){
        $('#stations_tbl tbody').append(`
        <tr>
            <td><input type="text"/></td>
            <td><input type="text"/></td>
            <td>
                <button type="button" class="add btn btn-sm btn-primary">提交添加</button>
            </td>
        </tr>`);

        $('.add').on('click',function(event){
            let $item = $(this).parent().parent();
            let stationId = $item.find('input').first().val(),
                stationName = $item.find('input').last().val();

            let myHeaders = new Headers({
                "Content-Type": "application/x-www-form-urlencoded"
             });
            let myInit = { 
                    method: 'POST',
                    headers: myHeaders,
                    credentials: "same-origin",
                    body: `stationId=${stationId}&stationName=${stationName}`
            };
            fetch("/trainBooking/addStation",myInit)
                .then(function(response){
                    if(response.ok){
                    	return response.text();
                        
                    }
                })
                .then(function(body){
	            	if(body === 'success'){
	            		$item.html(`
	                            <td>${stationId}</td>
	                            <td>${stationName}</td>
	                            <td>
	                                <button type="button" class="delete btn btn-sm btn-danger" id="${stationId}">删除站点</button>
	                                <button type="button" class="update_station btn btn-sm btn-success" id="${ stationId}">修改站点</button>
	                             </td>
	                        `);
	            		handleDelete();
	            		handleUpdateStation();
	            	}
	  
	            });
             
        });
});

handleDelete();

function handleDelete(){
    $('.delete').on('click',function(event){
        let stationId = $(this).attr('id');
        let $item = $(this).parent().parent();

        let myHeaders = new Headers({
            "Content-Type": "application/x-www-form-urlencoded"
         });
        let myInit = { 
            method: 'POST',
            headers: myHeaders,
            credentials: "same-origin",
            body: `stationId=${stationId}`
        };

        fetch("/trainBooking/deleteStation",myInit)
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

function handleUpdate(){
	$('.update').on('click',function(event){
        let $item = $(this).parent().parent();
        let stationId = $item.find('input').first().val(),
            stationName = $item.find('input').last().val();

        let myHeaders = new Headers({
            "Content-Type": "application/x-www-form-urlencoded"
         });
        let myInit = { 
                method: 'POST',
                headers: myHeaders,
                credentials: "same-origin",
                body: `stationId=${stationId}&stationName=${stationName}`
        };
        
        fetch("/trainBooking/updateStation",myInit)
            .then(function(response){
                if(response.ok){
                	return response.text();
                    
                }
            })
            .then(function(body){
            	if(body === 'success'){
            		$item.html(`
                            <td>${stationId}</td>
                            <td>${stationName}</td>
                            <td>
                                <button type="button" class="delete btn btn-sm btn-danger" id="${stationId}">删除站点</button>
                                <button type="button" class="update_station btn btn-sm btn-success" id="${ stationId}">修改站点</button>
                             </td>
                        `);
            		handleDelete();
            		handleUpdateStation();
            	}
  
            });
         
    });
}
handleUpdateStation();
function handleUpdateStation(){
	$('.update_station').on('click',function(event){
		let $item = $(this).parent().parent();
		let oldId = $item.find('td').first().html();
		let oldName = $item.find('td').eq(1).html();
		$item.html(`
		            <td><input type="text" value="${oldId}" disabled/></td>
		            <td><input type="text" value="${oldName}"/></td>
		            <td>
		                <button type="button" class="update btn btn-sm btn-primary">提交修改</button>
		            </td>
		            `);
		handleUpdate();
	})
}
