echo -e "\n\nAGGIUNGENDO CONNESSIONI..."

curl -H "Content-Type: application/json" -d '{"follower": "marco", "followed": "catia"}' -X POST http://localhost:8090/connessioni/connessioni

curl -H "Content-Type: application/json" -d '{"follower": "catia", "followed": "marco"}' -X POST http://localhost:8090/connessioni/connessioni

curl -H "Content-Type: application/json" -d '{"follower": "paolo", "followed": "catia"}' -X POST http://localhost:8090/connessioni/connessioni



echo -e "\n\nAGGIUNGENDO RICETTE..."

curl -H "Content-Type: application/json" -d '{"autore": "marco", "titolo": "Roast beef", "preparazione": "Lunga"}' -X POST http://localhost:8090/ricette/ricette

curl -H "Content-Type: application/json" -d '{"autore": "marco", "titolo": "Lasagna", "preparazione": "Media"}' -X POST http://localhost:8090/ricette/ricette

curl -H "Content-Type: application/json" -d '{"autore": "catia", "titolo": "Pizza", "preparazione": "Lunga"}' -X POST http://localhost:8090/ricette/ricette

curl -H "Content-Type: application/json" -d '{"autore": "paolo", "titolo": "Pasta", "preparazione": "Breve"}' -X POST http://localhost:8090/ricette/ricette



echo -e "\n\nCONNESSIONI:"

curl http://localhost:8090/connessioni/connessioni



echo -e "\n\nRICETTE:"

curl http://localhost:8090/ricette/ricette



echo -e "\n\nRICETTE SEGUITE:"

echo -e "\n\nda PAOLO:"
curl http://localhost:8090/ricette-seguite/ricetteseguite/paolo

echo -e "\n\nda MARCO:"
curl http://localhost:8090/ricette-seguite/ricetteseguite/marco

echo -e "\n\nda CATIA:"
curl http://localhost:8090/ricette-seguite/ricetteseguite/catia
