import logo from './logo.svg';
import {useDispatch, useSelector} from "react-redux";
import {getHello, login} from "./modules/reducer";
import {Button, Form, FormGroup} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.css';
import {useState} from "react";

function App() {
  let dispatch = useDispatch();
  let token = useSelector(state => state.token)
  let [username, setUsername] = useState("");
  let [password, setPassword] = useState("");
  function onSubmit(event){
    event.preventDefault();
    dispatch(login(username, password))
  }
  if(token){
    return (
        <p> You're Logged in </p>
    );
  }
  return (<>
    <Form onSubmit={onSubmit}>
      <FormGroup>
        <Form.Label>Username</Form.Label>
        <Form.Control
            type={"text"}
            placeholder={"username"}
            onChange={e => setUsername(e.target.value)}
        ></Form.Control>
      </FormGroup>
      <FormGroup>
        <Form.Label>Password</Form.Label>
        <Form.Control
            type={"password"}
            placeholder={"password"}
            onChange={e => setPassword(e.target.value)}
        ></Form.Control>
      </FormGroup>
      <Button type={"submit"}>Login</Button>
    </Form>
  </> );
}

export default App;
