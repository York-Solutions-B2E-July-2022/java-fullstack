import logo from './logo.svg';
import {useDispatch, useSelector} from "react-redux";
import {getHello, login} from "./modules/reducer";
import {Button, Col, Container, Form, FormGroup, Row} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.css';
import {useState} from "react";
import Login from "./components/Login";
import Logout from "./components/Logout";
import SignUp from "./components/SignUp";
import CreateThread from "./components/CreateThread";
import ThreadList from "./components/ThreadList";
import ThreadDetails from "./components/ThreadDetails";

function App() {
    let dispatch = useDispatch();
    let token = useSelector(state => state.token)
    let error = useSelector(state => state.error);
    let errorMessage = null;
    if (error){
        errorMessage = <p>{error}</p>
    }
    let content = null;
    if(token){
        content =(
            <>
                {errorMessage}
                <Row>
                    <Logout></Logout>

                </Row>
                <CreateThread></CreateThread>
            </>
        );
    } else {
        content = (<>
            {errorMessage}
                <Row>
                    <Col>
                        <Login></Login>
                    </Col>
                    <Col>
                        <SignUp></SignUp>
                    </Col>
                </Row>
        </>)
    }
    return (
        <>
        <Container>
            {content}
            <Row className={"mt-2"}>
                <ThreadList></ThreadList>
            </Row>
        </Container>
        <ThreadDetails></ThreadDetails>
        </>
    )
}

export default App;
