const initialState = {
    token: null,
    error: null,
    threads: [],
    selection: null,
}
const BASE_URL = 'http://localhost:8080'

export const FAILED = "FAILED";
export const STORE_TOKEN = "STORE_TOKEN";
export const REMOVE_TOKEN = "REMOVE_TOKEN";
export const STORE_THREADS = "STORE_THREADS";
export const SHOW_THREAD = "SHOW_THREAD";
export const CLEAR_SELECTION = "CLEAR_SELECTION";
export default function(state=initialState, action){
    state.error = null;
    switch (action.type) {
        case STORE_TOKEN: {
            return {...state, token: action.data}
        }
        case STORE_THREADS:{
            return {...state, threads: action.data}
        }
        case SHOW_THREAD:{
            return {...state, selection: state.threads.find(t => t.id == action.data)}
        }
        case CLEAR_SELECTION: {
            return {...state, selection: null}
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


