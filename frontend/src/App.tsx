import React, { useEffect, useState } from 'react';
import AxiosInstance from './AxiosInstance';


function App() {
  const [userInfo, setUserInfo] = useState<string | null>(null);

  useEffect(() => {
    const fetchUserInfo = async () => {
      try {
        const response = await AxiosInstance.get('/kwon');
        setUserInfo(response.data);
      } catch (error) {
        console.error('Error fetching user info', error);
      }
    };

    fetchUserInfo();
  }, []);

  return (
    <div className="App">
      <h1>User Information</h1>
      {userInfo ? <p>{userInfo}</p> : <p>Loading...</p>}
    </div>
  );
}

export default App;
