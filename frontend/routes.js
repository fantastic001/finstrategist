import Home from './src/views/Home.vue';
import SubmitStock from './src/views/SubmitStock.vue';
import Configuration from './src/views/Configuration.vue';

const routes = [
    { path: '/', component: Home },
    { path: '/addStock', component: SubmitStock },
    { path: '/configuration', component: Configuration },
    

];


export default routes;
