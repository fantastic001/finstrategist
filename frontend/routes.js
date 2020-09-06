import Home from './src/views/Home.vue';
import SubmitStock from './src/views/SubmitStock.vue';
import Configuration from './src/views/Configuration.vue';
import SubmitCompanyInfo from './src/views/SubmitCompanyInfo.vue';

const routes = [
    { path: '/', component: Home },
    { path: '/addStock', component: SubmitStock },
    { path: '/configuration', component: Configuration },
    { path: '/submitCompanyInfo', component: SubmitCompanyInfo },
    

];


export default routes;
