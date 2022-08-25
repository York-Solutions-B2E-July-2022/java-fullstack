import {Button, Form, FormGroup} from "react-bootstrap";
import {useState} from "react";
import {useDispatch} from "react-redux";
import {signup} from "../modules/requests";

export default ()=>{
    const dispatch = useDispatch();
    let [username, setUsername] = useState('');
    let [password, setPassword] = useState('');
    let [firstName, setFirstName] = useState('');
    let [lastName, setLastName] = useState('');
    function onSubmit(event){
        event.preventDefault();
        dispatch(signup(username, password, firstName, lastName));
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
            <FormGroup>
                <Form.Label>First Name</Form.Label>
                <Form.Control type={"text"} onChange={event => setFirstName(event.target.value)}></Form.Control>
            </FormGroup>
            <FormGroup>
                <Form.Label>Last Name</Form.Label>
                <Form.Control type={"text"} onChange={event => setLastName(event.target.value)}></Form.Control>
            </FormGroup>
            <Button type={"submit"}>Sign Up</Button>
        </Form>
    </>)
}