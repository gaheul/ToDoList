
const submitBtn = document.querySelector("button");
const inputs = document.querySelectorAll("input");

submitBtn.onclick = async() => {
	//console.log(inputs[0].value)
	let result = await usernameCheck(inputs[0].value); //usernameCheck실행이 되고 완전히 끝나고 난 뒤에 if실행위해
	//console.log(result);
	if(result ==true){//result가 true이면
		const url = `/api/v1/auth/signup`;
		const bodyObj = {
			username: inputs[0].value,
			password: inputs[1].value,
			name: inputs[2].value,
			email: inputs[3].value
		};
		
		const option = {
			method: "POST",
			headers: {
				"Content-Type": "application/json"
			},
			body:JSON.stringify(bodyObj)
		}
		await request(url,option)
		.then(result => {
			console.log(result);
			return result.data;
		})
		.then(data => {
			if(data ==true){
				alert("회원가입 성공");
			}else{
				alert(JSON.stringify(data));
			}
		})
		.catch(error => {
			console.log(error);
		});
	 }else{
			alert(JSON.stringify(result));
		}	
	}	


async function usernameCheck(username){
	const url = `/api/v1/auth/signup/username?username=${username}`;
	
	let responseData = false;
	
	await request(url)
	.then(result => {
		console.log(result);
		responseData = result.data;
	})
	.catch(error => {
		console.log(error);
	})
	return responseData;
}


/*
async function request(url){
	const response = await fetch(url);
	if(response.ok){
		return response.json();
	}else{
		throw new Error("response Error: " + response)
	}
}*/

async function request(url, option){
	const response = await fetch(url,option);
	
	if(response.ok){ //결과를 받기위해서 
		return response.json(); // -> cmrespdto
	} else{ //handler의 badrequest로 할경우 ->error 띄워서 뒷로직 실행안됨
		throw new Error("response Error: " + response);
	}
}

