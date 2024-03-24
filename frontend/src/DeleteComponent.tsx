import React from "react";
import { SERVER_URL } from "./constant";

interface DeleteComponentProps {
    id: number;
    handleClick: () => void;
}

function DeleteComponent({ id, handleClick }: DeleteComponentProps) {
    function deleteCar() {
        const requestOptions: RequestInit = {
            method: "DELETE",
            headers: { 'Content-Type': 'application/json' },
            credentials: 'include'
        };

        fetch(
            SERVER_URL + '/car/' + id,
            requestOptions
        ).then(async response => {
            if (!response.ok) {
                console.log("Error happened");
            }

            handleClick();
        });
    }

    return (
        <button onClick={deleteCar}>Delete</button>
    );
}

export default DeleteComponent;
