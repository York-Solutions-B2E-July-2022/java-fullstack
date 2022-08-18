import {useSelector} from "react-redux";

export default ()=>{
    let threads = useSelector(s => s.threads);
    return threads.map((t, idx) => {
        return (<p key={idx}>{t.title}</p>)
    })
}