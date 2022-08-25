import {FAILED, REMOVE_TOKEN, STORE_TOKEN} from "../reducer";
const BASE_URL = "http://localhost:8080"
export function login(username, password){
    return async ( dispatch, getState)=>{
        const response = await fetch(
            `${BASE_URL}/login?username=${username}&password=${password}`)
        let data = await response.json();
        if(response.status > 200){
            console.log(data);
            return dispatch({type: FAILED, data: data.message})
        }
        dispatch({type: STORE_TOKEN, data})
    }
}
export function logout(){
    return async (dispatch, getState) => {
        let token = getState().token;
        const res = await fetch(`${BASE_URL}/logout?token=${token}`)
        if(!res.ok){
            let data = await res.json();
            return dispatch({type: FAILED, data: data.message})

        }
        dispatch({type: REMOVE_TOKEN})
    }
}
export function signup(username, password){
    return async (dispatch, getState) => {
        const res = await fetch(`${BASE_URL}/signup?username=${username}&password=${password}`)
        if(!res.ok) {
            let data = await res.json();
            return dispatch({type: FAILED, data: data.message})
        }
    }
}
