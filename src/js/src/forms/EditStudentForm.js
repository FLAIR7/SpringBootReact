import React, {Component} from 'react';
import { Formik } from 'formik';
import { Input, Tag, Button } from 'antd';

const inputBottomMargin = {marginBottom: '10px'}
const tagStyle = {backgroundColor: '#32a852', color: '#ffffff', ...inputBottomMargin};

export default class EditStudentForm extends Component {
    render () {
        const { submitter, initialValues } = this.props;
        return (
            <Formik
            initialValues={initialValues}
            validate={values => {
                const errors = {};

                if(!values.firstName) {
                    errors.firstName = 'First name required';
                }

                if(!values.lastName) {
                    errors.lastName = 'Last name required';
                }

                if(!values.email) {
                    errors.email = 'Required';
                } else if(
                    !/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(values.email)
                ) {
                    errors.email = 'Invalid email address';
                }

                if(!values.gender) {
                    errors.gender = 'Gender is required';
                } else if(!['MALE', 'male', 'FEMALE', 'female'].includes(values.gender)) {
                    errors.gender = 'Gender must be (MALE, male, FEMALE, female)';
                }
    

                return errors;
            }}
            onSubmit={(values, { setSubmitting }) => {
                console.log(values)
                submitter(values);
                setSubmitting(false);
            }}>
            {({
                values,
                errors,
                touched,
                handleChange,
                isValid,
                handleBlur,
                handleSubmit,
                isSubmitting,
                submitForm
            }) => (
                <form onSubmit={handleSubmit}>
                    <Input
                        style={inputBottomMargin}
                        name="firstName"
                        onChange={handleChange}
                        onBlur={handleBlur}
                        value={values.firstName}
                        placeholder='First name'
                    />
                    {errors.firstName && touched.firstName && 
                            <Tag style={tagStyle}>{errors.firstName}</Tag>}

                    <Input
                        style={inputBottomMargin}
                        name="lastName"
                        onChange={handleChange}
                        onBlur={handleBlur}
                        value={values.lastName}
                        placeholder='Last name'
                    />
                    {errors.lastName && touched.lastName && 
                            <Tag style={tagStyle}>{errors.lastName}</Tag>}
                   
                    <Input
                        style={inputBottomMargin}
                        type="email"
                        name="email"
                        onChange={handleChange}
                        onBlur={handleBlur}
                        value={values.email}
                        placeholder='Email'
                    />
                    {errors.email && touched.email && 
                            <Tag style={tagStyle}>{errors.email}</Tag>}

                    <Input
                        style={inputBottomMargin}
                        name="gender"
                        onChange={handleChange}
                        onBlur={handleBlur}
                        value={values.gender}
                        placeholder='Gender'
                    />
                    {errors.gender && touched.gender && 
                            <Tag style={tagStyle}>{errors.gender}</Tag>}

                    <Button 
                        onClick={() => submitForm()} 
                        type="submit" 
                        disabled={isSubmitting | (touched && !isValid)}>
                        Submit
                    </Button>
                </form>
            )}
            </Formik>
        );
    }
}