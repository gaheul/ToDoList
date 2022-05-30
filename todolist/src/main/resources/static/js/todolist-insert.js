
 const todoInput = document.querySelector('.todo-input');
 const todoBtn = document.querySelector('.todo-btn');
 const content = document.querySelector('.content');


 
 
 load();
 
 function load(){
	let url = "/api/v1/todo/list";
	
	fetch(url)
	.then(response=>{
		if(response.ok){
			return response.json();
		}else{
			throw new Error("비동기 처리 오류");
		}
	})
	.then(result => {
		console.log(result);
		getTodolist(result);
	})
	.catch(error=> {console.log(error)});
}

 function getTodolist(result){
	let listStr = ``;
	for(let i=0; i<result.length; i++){
	 listStr += `
		<div class="content-list">
            <span>${result[i].content}</span>
            <button type="button" class="update-btn">수정</button>
            <button type="button" class="delete-btn">삭제</button>
        </div>
	`;
		
	}
	
	content.innerHTML = listStr;
	
	const updateBtn = document.querySelectorAll('.update-btn');
	const deleteBtn = document.querySelectorAll('.delete-btn');
	const listCon = document.querySelectorAll('.list-con');
	
	for(let i =0; i<updateBtn.length; i++){
		updateBtn[i].onclick = () =>{
			alert("수정");
			
			let url = `api/v1/todo/${result[i].id}`;
			let option = {
				method: "PUT",
				headers: {
					"Conntent-Type":"application/json"
				},
				body: JSON.stringify({
					content:listCon[i].textContent
				})
			}
			fetch(url,option)
			.then(result => {
				console.log(result)
			})
			.catch(error => {
				console.log(error)
			})
			
		}
		deleteBtn[i].onclick = () =>{
			alert("삭제");
			
			let url = `/api/v1/todo/${result[i].id}`;
			let option = {
				method:"DELETE"
			}
			
			fetch(url,option)
			.then(response=>{
				if(response.ok){
					return response.json();
				}else{
					throw new Error("오류");
				}
			})
			.then(result => {
				load(result);
			})
			.catch(error=> console.log(error));
		}
	}
	
}




 
 todoBtn.onclick = () => {
	let url = "/api/v1/todo";
	
	
	
	let option = {
		method: "POST",
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify({
			content: todoInput.value
		})
	};
	
	fetch(url,option)
	.then(response =>{
		if(response.ok){
			return response.json();
		}else{
			throw new Error("오류");
		}
	})
	.then(result => {
		load(result);
	})
	.catch(error => console.log(error));
}


 