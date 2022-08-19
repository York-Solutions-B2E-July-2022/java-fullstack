import {useDispatch, useSelector} from "react-redux";
import {ListGroup} from "react-bootstrap";
import {SHOW_THREAD} from "../modules/reducer";

export default ()=>{
    const dispatch = useDispatch();
    let threads = useSelector(s => s.threads);
    //return threads.map((t, idx) => {
    //    return (<p key={idx}>{t.title}</p>)
    //})
    function onClick(id){
        dispatch({type: SHOW_THREAD/*TODO*/, data: id})
    }
    return (
        <ListGroup>
            {
                threads.map((t, idx)=>{
                    return (
                        <ListGroup.Item key={idx} onClick={e => onClick(t.id)}>
                            <p>{t.title}</p>
                        </ListGroup.Item>);
                })
            }
        </ListGroup>
    );
}