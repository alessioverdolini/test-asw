#!/bin/bash

echo Tests projects...
echo ""
echo ""
echo "Connessioni"
echo ""
curl http://localhost:8090/connessioni/connessioni
echo ""
echo ""
echo ""
echo "Ricette"
echo ""
curl http://localhost:8090/ricette/ricette
echo ""
echo ""
echo ""
echo "Ricette seguite da Gennaro"
echo ""
curl http://localhost:8090/ricette-seguite/ricetteseguite/Gennaro
