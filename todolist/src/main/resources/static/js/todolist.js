/**
 * 
 */
 const todoInput = document.querySelector('.todo-input');
 const todoBtn = document.querySelector('.todo-btn');
 
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
	.then(result => console.log(result))
	.catch(error => console.log(error));
}