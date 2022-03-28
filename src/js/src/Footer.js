import React from 'react';
import Container from './Container';
import { Button, Avatar } from 'antd';
import './Footer.css';

const Footer = (props) => (
    <div className='footer'>
        <Container>
            {props.numberOfStudents ? 
<<<<<<< HEAD
            <Avatar 
                style={{backgroundColor: '#f56a00', marginRight: '5px'}}
                size='large'>{props.numberOfStudents}</Avatar> : null}
            <Button onClick={() => props.handleAddStudentClickEvent()} type='primary'>Add new student +</Button>
=======
                <Avatar 
                    style={{backgroundColor: '#32a84c', marginRight: '5px'}} 
                    size='large'>{props.numberOfStudents}</Avatar> : null
            }
            <Button onClick= {() => props.handleAddStudentClickEvent()}type='primary'>Add new student +</Button>
>>>>>>> 11ea5b37f781ea12f2d3dac72fbe9a888d40513f
        </Container>
    </div>
);

export default Footer;