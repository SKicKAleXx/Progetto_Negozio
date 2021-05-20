

const ProductScreen = {
    after_render: () => {
        const request = parseRequestUrl();
        document.getElementById('add-button').addEventListener('click', () => {
            document.location.hash = `/cart/${request.id}`;
        });
    },
};
export default ProductScreen;



