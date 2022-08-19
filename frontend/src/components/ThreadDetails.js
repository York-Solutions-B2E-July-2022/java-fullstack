import {Button, ButtonGroup, Form, Modal} from "react-bootstrap";
import {useDispatch, useSelector} from "react-redux";
import {CLEAR_SELECTION, editThread} from "../modules/reducer";
import {useState} from "react";

export default ()=>{
    let thread = useSelector(s => s.selection)
    let token = useSelector(s => s.token)
    let [editing, setEditing ]=  useState(false)
    let [ title, setTitle] = useState(thread? thread.title: "" )
    let [ description, setDescription] = useState(thread? thread.description: "" )
    const dispatch = useDispatch();
    function onSubmit(){
        console.log("click")
        dispatch(editThread(undefined, title, description))
        onClose();
    }
    function onClose(){
        setEditing(false);
        setTitle('')
        setDescription('')

        dispatch({type: CLEAR_SELECTION})
    }
    return  (
        <Modal show={!!thread}>

            <Modal.Header> {
                editing ?
                    <Form.Control
                        placeholder={thread?.title}
                        value={title}
                        onChange={ e => setTitle(e.target.value)}>

                    </Form.Control>:
                    thread?.title
            }</Modal.Header>
            <Modal.Body>{
                editing ?
                    <Form.Control as={"textarea"}
                                  placeholder={thread?.description}
                                  value={description}
                                  onChange={e=> setDescription(e.target.value)}
                    ></Form.Control>:
                    thread?.description
            }</Modal.Body>
            <Modal.Footer>
                <ButtonGroup>
                    { editing ?
                        <Button onClick={ () => onSubmit()}> Submit</Button>:
                        <Button type={"button"} onClick={e=> setEditing(true) } disabled={!token}>Edit</Button> }

                    <Button onClick={e=> onClose()}>Close</Button>
                </ButtonGroup>
            </Modal.Footer>
        </Modal>
    );

}