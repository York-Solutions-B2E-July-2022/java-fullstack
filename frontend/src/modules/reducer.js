const initialState = {
    token: null,
}
const LOGIN_FAILED = "LOGIN_FAILED";
const STORE_TOKEN = "STORE_TOKEN";
const BASE_URL = 'http://localhost:8080'
export default function(state=initialState, action){
    switch (action.type) {
        case STORE_TOKEN: {
            return {...state, token: action.data}
        }
        case LOGIN_FAILED: {

        }
    }
    return state
}
export function getHello(){
    return async (dispatch, getState)=>{
        let response = await fetch('http://localhost:8080/hello');
        let data = await response.json();
        console.log(data);
    }
}
export function login(username, password){
    return async ( dispatch, getState)=>{
        const response = await fetch(
            `${BASE_URL}/login?username=${username}&password=${password}`)

        if(response.statusCode > 200){
           dispatch(/* LOGIN FAILED*/)
        }
        let data = await response.text();
        dispatch({type: STORE_TOKEN, data})
    }
}