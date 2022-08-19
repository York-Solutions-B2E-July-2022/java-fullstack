import {Button, ButtonGroup, Form, Modal} from "react-bootstrap";
import {useDispatch, useSelector} from "react-redux";
import {CLEAR_SELECTION} from "../modules/reducer";
import {useState} from "react";

export default ()=>{
    let thread = useSelector(s => s.selection)
    let [editing, setEditing ]=  useState(false)
    const dispatch = useDispatch();
    function onSubmit(){
        console.log("click")
    }
    return  (
        <Modal show={!!thread}>

            <Modal.Header> {
                editing ?
                    <Form.Control placeholder={thread?.title}></Form.Control>:
                    thread?.title
            }</Modal.Header>
            <Modal.Body>{
                editing ?
                    <Form.Control as={"textarea"} placeholder={thread?.description}></Form.Control>:
                    thread?.description
            }</Modal.Body>
            <Modal.Footer>
                <ButtonGroup>
                    { editing ?
                        <Button onClick={ () => onSubmit()}> Submit</Button>:
                        <Button type={"button"} onClick={e=> setEditing(true) }>Edit</Button> }

                    <Button onClick={e=> {
                        setEditing(false);
                        dispatch({type: CLEAR_SELECTION})
                    }}>Close</Button>
                </ButtonGroup>
            </Modal.Footer>
        </Modal>
    );

}