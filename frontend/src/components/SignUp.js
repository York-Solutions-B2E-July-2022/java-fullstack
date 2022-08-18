import {Button, Form, FormGroup} from "react-bootstrap";
import {useState} from "react";
import {useDispatch} from "react-redux";
import {signup} from "../modules/reducer";

export default ()=>{
    const dispatch = useDispatch();
    let [username, setUsername] = useState('');
    let [password, setPassword] = useState('');
    function onSubmit(event){
        event.preventDefault();
        dispatch(signup(username, password));
    }
    return (<>
        <Form onSubmit={onSubmit}>
            <FormGroup>
                <Form.Label>Username</Form.Label>
                <Form.Control type={"text"} onChange={event => setUsername(event.target.value)}></Form.Control>
            </FormGroup>
            <FormGroup>
                <Form.Label>Password</Form.Label>
                <Form.Control type={"password"} onChange={event => setPassword(event.target.value)}></Form.Control>
            </FormGroup>
            <Button type={"submit"}>Sign Up</Button>
        </Form>
    </>)
}