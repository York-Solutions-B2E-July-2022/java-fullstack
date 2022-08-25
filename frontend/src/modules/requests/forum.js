import {FAILED, STORE_THREADS} from "../reducer";

const BASE_URL = "http://localhost:8081"
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
export function editThread( title, description){
    return async (dispatch, getState)=>{
        let thread = getState().selection;
        let token = getState().token;
        thread.title = title? title: thread.title;
        thread.description = description? description: thread.description;
        const res = await fetch(`${BASE_URL}/editForumThreads?token=${token}`, {
            method: "POST",
            body: JSON.stringify(thread),
            headers: {
                "Content-Type": "application/json",
            }
        })
        if(!res.ok){
            let data = await res.json();
            return dispatch({type: FAILED, data: data.message})
        }
        dispatch(getThreads())

    }
}
export function deleteThread(){
    return async (dispatch, getState)=>{
        let thread = getState().selection;
        let token = getState().token;
        const res = await fetch(`${BASE_URL}/deleteForumThreads?token=${token}&id=${thread.id}`, {
            method: "DELETE",
        })
        if(!res.ok){
            let data = await res.json();
            return dispatch({type: FAILED, data: data.message})
        }
        dispatch(getThreads())

    }
}