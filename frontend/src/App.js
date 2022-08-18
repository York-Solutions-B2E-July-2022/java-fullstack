import logo from './logo.svg';
import {useDispatch, useSelector} from "react-redux";
import {getHello, login} from "./modules/reducer";
import {Button, Form, FormGroup} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.css';
import {useState} from "react";
import Login from "./components/Login";
import Logout from "./components/Logout";
import SignUp from "./components/SignUp";
import CreateThread from "./components/CreateThread";
import ThreadList from "./components/ThreadList";

function App() {
    let dispatch = useDispatch();
    let token = useSelector(state => state.token)
    let error = useSelector(state => state.error);
    let errorMessage = null;
    if (error){
        errorMessage = <p>{error}</p>
    }
    if(token){
        return (
            <>
                {errorMessage}
                <Logout></Logout>
                <CreateThread></CreateThread>
                <ThreadList></ThreadList>
            </>
        );
    } else {
        return (<>
            {errorMessage}
            <Login></Login>
            <SignUp></SignUp>
            <ThreadList></ThreadList>
        </>)
    }

}

export default App;
