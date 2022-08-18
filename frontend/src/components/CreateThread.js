import {Button, Form, FormGroup} from "react-bootstrap";
import {useState} from "react";
import {useDispatch} from "react-redux";
import {createThread} from "../modules/reducer";
export default ()=>{
    const dispatch = useDispatch();
    let [ title, setTitle] = useState("");
    let [ description , setDescription] = useState("");
    function onSubmit(event){
        event.preventDefault();
        dispatch(createThread(title, description));
    }
    return (<>
        <Form onSubmit={onSubmit}>
            <FormGroup>
                <Form.Label> Title </Form.Label>
                <Form.Control type={"text"} onChange={e => setTitle(e.target.value)}></Form.Control>
            </FormGroup>
            <FormGroup>
                <Form.Label> Description </Form.Label>
                <Form.Control as={"textarea"} onChange={e => setDescription(e.target.value)}></Form.Control>
            </FormGroup>
            <Button type={"submit"}>Submit</Button>
        </Form>
    </>)
}