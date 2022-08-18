const initialState = {
    token: null,
    error: null,
    threads: [],
}
const FAILED = "FAILED";
const STORE_TOKEN = "STORE_TOKEN";
const REMOVE_TOKEN = "REMOVE_TOKEN";
const STORE_THREADS = "STORE_THREADS";
const BASE_URL = 'http://localhost:8080'
export default function(state=initialState, action){
    state.error = null;
    switch (action.type) {
        case STORE_TOKEN: {
            return {...state, token: action.data}
        }
        case STORE_THREADS:{
            return {...state, threads: action.data}
        }
        case REMOVE_TOKEN:{
            return {...state, token: null}
        }
        case FAILED: {
            return {...state, error: action.data}
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

export function createThread(title, description){
    return async (dispatch, getState)=>{
        const token = getState().token;
        const res = await fetch(`${BASE_URL}/createForumThread?token=${token}&title=${title}&description=${description}`)
        if(!res.ok){
            let data = await res.json();
            return dispatch({type: FAILED, data: data.message})
        }
        dispatch(getThreads())
    }
}
export function getThreads(){
    return async (dispatch, getState)=>{

        const res = await fetch(`${BASE_URL}/forumThreads`)
        const data = await res.json();
        dispatch({type: STORE_THREADS, data})
    }
}